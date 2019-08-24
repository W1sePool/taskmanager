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
                update: 'PUT'
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

    Ext.create('Ext.grid.Panel', {
        title: 'Tasks',
        height: 400,
        width: 600,
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
                text: 'delete', //то что написанно
                align: 'center',// все элементы по центру
                xtype: 'actioncolumn', // в этих колонках генерируются действия
                items: [{
                    xtype: 'button',
                    text: 'Delete',
                    scale: 'small',
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
                            items: [{
                                xtype: 'textfield',
                                name: 'name',
                                fieldLabel: 'Name'
                            }, {
                                xtype: 'textfield',
                                name: 'number',
                                fieldLabel: 'Number'
                            }],
                            buttons: [{
                                text: 'Update',
                                handler: function () {
                                    var values = modalDialog.getValues();
                                    var task = Ext.create('Task', {
                                        name: values.name,
                                        number: values.number,
                                        id: record.data.id
                                    })
                                    task.save();
                                    taskStore.load();
                                    modalDialog.close();
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
                }]
            }
        ],
        renderTo: Ext.getBody() //нарисовать в боди

    })
    var form = Ext.create('Ext.form.Panel', {
        title: 'forma',
        heigth: 300,
        width: 250,
        renderTo: Ext.getBody(),//нарисовать в боди .
        items: [
            {
                xtype: 'textfield',
                fieldLabel: 'name',
                name: 'name',
                labelAlign: 'top',
                cls: 'field-margin',
                flex: 1
            }, {
                xtype: 'textfield',
                fieldLabel: 'number',
                name: 'number',
                labelAlign: 'top',
                cls: 'field-margin',
                flex: 1
            }, {
                xtype: 'combobox',
                fieldLabel:'From address',
                autoSelect:true,   //автоматическаий выбор
                store:fromAddressStore,
                name:'fromAddress',
                valueField:'name',//поле из модели которое отвечает за значение
                displayField:'name'//поле из моделей которое отвечает за отображениебfd
            }
        ],
        buttons: [
            {
                text: 'save',
                handler: function () {
                    form.getForm().submit({
                        url: 'tasks',
                        jsonSubmit: true, //преобразовать результат в джсон
                        success: function () {
                            taskStore.load()//перегрузить данные в сторедже
                        }
                    })
                }

            }
        ]
    })

})