Ext.onReady(function () {

    Ext.define('Task', {//создаем обьект ext
        extend: 'Ext.data.Model',//обьявляем обьект моделью
        fields: [//обьявляем поля модели
            {name: 'id', type: 'int'},
            {name: 'number', type: 'int'},
            {name: 'name', type: 'string'},
            {name: 'fromAddress', type: 'string'},
            {name: 'toAddress', type: 'string'},
            {name: 'status', type: 'string'}
        ],
        proxy: {//API работы с обьяектом
            type: 'ajax',//типы работы ajax - фоновые запросы
            url: 'tasks',//адресс куда направляем запросы
            actionMethods: {//типы завпросов
                create: 'POST',
                read: 'GET',
                update: 'PUT',
                destroy: 'DELETE'
            }
        }
    });

    Ext.define('FromAddress', {//создаем обьект ext
        extend: 'Ext.data.Model',//обьявляем обьект моделью
        fields: [//обьявляем поля модели
            {name: 'name', type: 'string'}
        ],
        proxy: {//API работы с обьяектом
            type: 'ajax',//типы работы ajax - фоновые запросы
            url: 'dictionaries/fromAddress',//адресс куда направляем запросы
            actionMethods: {//типы завпросов
                read: 'GET'
            }
        }
    });
    Ext.define('ToAddress', {//создаем обьект ext
        extend: 'Ext.data.Model',//обьявляем обьект моделью
        fields: [//обьявляем поля модели
            {name: 'name', type: 'string'}
        ],
        proxy: {//API работы с обьяектом
            type: 'ajax',//типы работы ajax - фоновые запросы
            url: 'dictionaries/toAddress',//адресс куда направляем запросы
            actionMethods: {//типы завпросов
                read: 'GET'
            }
        }
    });
    Ext.define('Status', {//создаем обьект ext
        extend: 'Ext.data.Model',//обьявляем обьект моделью
        fields: [//обьявляем поля модели
            {name: 'name', type: 'string'}
        ],
        proxy: {//API работы с обьяектом
            type: 'ajax',//типы работы ajax - фоновые запросы
            url: 'dictionaries/status',//адресс куда направляем запросы
            actionMethods: {//типы завпросов
                read: 'GET'
            }
        }
    });


    Ext.define('TaskStore', {//создаенм обьяект ext
        extend: 'Ext.data.Store',//обьявляем extend - хранилищем
        model: 'Task',//какой обьяект храним - Task
        autoLoad: true//включаем автозагрузку
    });
    Ext.define('FromAddressStore', {//создаенм обьяект ext
        extend: 'Ext.data.Store',//обьявляем extend - хранилищем
        model: 'FromAddress',//какой обьяект храним - Task
        autoLoad: true//включаем автозагрузку
    });
    Ext.define('ToAddressStore', {//создаенм обьяект ext
        extend: 'Ext.data.Store',//обьявляем extend - хранилищем
        model: 'ToAddress',//какой обьяект храним - Task
        autoLoad: true//включаем автозагрузку
    });
    Ext.define('StatusStore', {//создаенм обьяект ext
        extend: 'Ext.data.Store',//обьявляем extend - хранилищем
        model: 'Status',//какой обьяект храним - Task
        autoLoad: true//включаем автозагрузку
    });

    var taskStore = Ext.create('TaskStore');
    var fromAddressStore = Ext.create('FromAddressStore');
    var toAddressStore = Ext.create('ToAddressStore');
    var statusStore = Ext.create('StatusStore');
    var form = Ext.create('Ext.form.Panel', {
        bodyPadding: 10,
        title: 'forma',
        heigth: 300,
        width: 300,
        renderTo: Ext.getBody(),//нарисовать в боди .
        items: [
            {
                validator: function (value) {
                    if (!value) {
                        return 'введите значение'

                    }
                    return true
                },
                msgTarget: 'under',
                xtype: 'textfield',
                fieldLabel: 'name',
                name: 'name',
                //labelAlign: 'top',
                cls: 'field-margin',
                flex: 1
            }, {
                xtype: 'numberfield',
                fieldLabel: 'number',
                name: 'number',
                //labelAlign: 'top',
                cls: 'field-margin',
                flex: 1
            }, {
                xtype: 'combobox',
                fieldLabel: 'From address',
                autoSelect: true,   //автоматическаий выбор
                store: fromAddressStore,
                name: 'fromAddress',
                valueField: 'name',//поле из модели которое отвечает за значение
                displayField: 'name'//поле из моделей которое отвечает за отображениебfd
                // margin:'10 25 50 100'
            },
            {
                xtype: 'combobox',
                fieldLabel: 'To address',
                autoSelect: true,   //автоматическаий выбор
                store: toAddressStore,
                name: 'toAddress',
                valueField: 'name',//поле из модели которое отвечает за значение
                displayField: 'name'//поле из моделей которое отвечает за отображениебfd
            },
            {
                xtype: 'combobox',
                fieldLabel: 'Status',
                autoSelect: true,   //автоматическаий выбор
                store: statusStore,
                name: 'status',
                valueField: 'name',//поле из модели которое отвечает за значение
                displayField: 'name'//поле из моделей которое отвечает за отображениебfd
            }, {
                xtype: 'button',
                text: 'save',
                scale: 'small',
                icon: 'icons/save-icon1.png',
                handler: function () {
                    form.getForm().submit({
                            url: 'tasks',
                            jsonSubmit: true, //преобразовать результат в джсон
                            success: function () {
                                taskStore.load()//перегрузить данные в сторедже
                            }
                        }
                    )
                }

            }
        ]
    })

    Ext.create('Ext.grid.Panel', {
        title: 'Tasks',
        height: 400,
        width: 750,
        store: taskStore,//какой стор отображать в табличке
        columns: [
            {header: 'id', dataIndex: 'id'},
            {header: 'Name', dataIndex: 'name'},
            {header: 'Number', dataIndex: 'number'},
            {header: 'From Address', dataIndex: 'fromAddress'},
            {header: 'To Address', dataIndex: 'toAddress'},
            {header: 'Status', dataIndex: 'status'},

            {
                header: 'Actions',
                align: 'center',// все элементы по центру
                xtype: 'actioncolumn', // в этих колонках генерируются действия
                items: [{
                    icon: 'icons/update.png',
                    xtype: 'button',
                    scale: 'small',//небольшая
                    handler: function (grid, rowIndex) {
                        var record = grid.getStore().getAt(rowIndex);//получаем сторейдж в таблице а в нем получаем запись по индексу строки
                        var modalDialog = Ext.create('Ext.form.Panel', {
                            xtype: 'formpanel', // это тип элемента форма панели
                            title: 'Edit task',
                            width: 300,
                            heigth: 300,
                            floating: true,
                            centered: true,
                            modal: true,
                            items: [
                                {
                                    validator: function (value) {
                                        if (!value) {
                                            return 'введите значение'

                                        }
                                        return true
                                    },
                                    msgTarget: 'under',
                                    xtype: 'textfield',
                                    fieldLabel: 'name',
                                    name: 'name',
                                    //labelAlign: 'top',
                                    cls: 'field-margin',
                                    flex: 1
                                }, {
                                    xtype: 'numberfield',
                                    fieldLabel: 'number',
                                    name: 'number',
                                    //labelAlign: 'top',
                                    cls: 'field-margin',
                                    flex: 1
                                }, {
                                    xtype: 'combobox',
                                    fieldLabel: 'From address',
                                    autoSelect: true,   //автоматическаий выбор
                                    store: fromAddressStore,
                                    name: 'fromAddress',
                                    valueField: 'name',//поле из модели которое отвечает за значение
                                    displayField: 'name'//поле из моделей которое отвечает за отображениебfd
                                    // margin:'10 25 50 100'
                                },
                                {
                                    xtype: 'combobox',
                                    fieldLabel: 'To address',
                                    autoSelect: true,   //автоматическаий выбор
                                    store: toAddressStore,
                                    name: 'toAddress',
                                    valueField: 'name',//поле из модели которое отвечает за значение
                                    displayField: 'name'//поле из моделей которое отвечает за отображениебfd
                                },
                                {
                                    xtype: 'combobox',
                                    fieldLabel: 'Status',
                                    autoSelect: true,   //автоматическаий выбор
                                    store: statusStore,
                                    name: 'status',
                                    valueField: 'name',//поле из модели которое отвечает за значение
                                    displayField: 'name'//поле из моделей которое отвечает за отображениебfd
                                }

                            ],
                            buttons: [{
                                text: 'Update',

                                handler: function () {


                                    var valid = true;

                                    modalDialog.items.each(function (elem) {//пройтись по всем элементам выподающего списка
                                        try {
                                            if (elem.validator(elem.value) != true)
                                                valid = false;
                                        }catch(e){}
                                    })
                                    if (valid){
                                        var values = modalDialog.getValues();
                                        var task = taskStore.findRecord('id', record.data.id); //найти запись в скобках указывает по какому параметру
                                        task.set('name', values.name); //установить ей параметр
                                        task.set('number', values.number);
                                        task.set('fromAddress', values.fromAddress);
                                        task.set('toAddress', values.toAddress);
                                        task.set('status', values.status);
                                        task.save({
                                            success: function () {
                                                modalDialog.close();
                                            },
                                            failure: function () {
                                                Ext.Msg.alert('fail');
                                                task.reject();//откатить изменение
                                            }
                                        });

                                    }
                                    else {
                                        Ext.Msg.alert('заполните поля')
                                    }

                                }

                            }, {
                                text: 'Close',
                                handler: function () {
                                    modalDialog.close();
                                }
                            }]
                        })
                        modalDialog.show();
                        modalDialog.loadRecord(record)
                    }
                },
                    {
                        xtype: 'button',
                        icon: 'icons/iconsDelete.png',
                        scale: 'small',
                        handler: function (grid, rowIndex) {
                            var record = grid.getStore().getAt(rowIndex);
                            var task = taskStore.findRecord('id', record.data.id);
                            task.destroy();
                        }


                    }
                ]
            }
        ],

        renderTo: Ext.getBody() //нарисовать в боди

    })
})