layui.use(['jquery', 'table'], function () {
    var $ = layui.$, table = layui.table;
    table.render({
        elem: '#user-list'
        , url: '/user/getUsers'
        , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        , cols: [[
            {field: 'id', title: 'ID', sort: true}
            , {field: 'username', title: '用户名'}
            , {field: 'status', title: '状态'}
            , {fixed: 'right', width: 178, align: 'center', toolbar: '#barDemo', title: '操作'}
        ]]
    });

    //监听工具条
    table.on('tool(user-list-filter)', function (obj) {
        console.info(obj);
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                console.info(index);
                obj.del();
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            layer.alert('编辑行：<br>' + JSON.stringify(data))
        }
    });
});