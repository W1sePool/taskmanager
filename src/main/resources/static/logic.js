Ext.onReady(function () {
    Ext.define('Task', {//создаем обьект ext
        extend: 'Ext.data.Model',//обьявляем обьект моделью
        fields: [//обьявляем поля модели
            {name:'id',type:'int'},
            {name:'number',type:'int'},
            {name:'name',type:'string'}
        ],
        proxy:{//API работы с обьяектом
            type:'ajax',//типы работы ajax - фоновые запросы
            url:'tasks',//адресс куда направляем запросы
            actionMethods:{//типы завпросов
                create:'POST',
                read:'GET',
                update:'PUT'
            }
        }
    });

    Ext.define('TaskStore',{//создаенм обьяект ext
        extend:'Ext.data.Store',//обьявляем extend - хранилищем
        model:'Task',//какой обьяект храним - Task
        autoLoad:true//включаем автозагрузку
    });

    var taskStore = Ext.create('TaskStore');

    Ext.create('Ext.grid.Panel',{
        title:'Tasks',
        height:400,
        width:600,
        store:taskStore,
        columns:[
            {header:'Name',dataIndex:'name'},
            {header:'Number',dataIndex:'number'}
        ],
        renderTo:Ext.getBody()

    })
})