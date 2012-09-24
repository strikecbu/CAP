$(document).ready(function(){
    var grid, mform = $("#mform");
	console.debug
    grid = $("#gridview").jqGrid({
        url: 'webroot/codetypehandler/query',
        colModel: [{
            name: 'oid',
            width: 90,
            align: "center",
            hidden: true
        }, {
            name: 'cdeType',
            width: 110,
            align: "center"
        }, {
            name: 'cdeVal',
            width: 80,
            align: "center"
        }, {
            name: 'cdeDesc',
            width: 80,
            align: "center"
        }, {
            name: 'cdeOrd',
            width: 80,
            align: "center"
        }, {
            header: i18n.def.lastModBy,
            name: 'lastModBy',
            width: 80,
            align: "center"
        }, {
            header: i18n.def.lastModTm,
            name: 'lastModTm',
            width: 80,
            align: "center"
        }],
        //localFirst: true,
        multiselect: false,
        sortname: 'cdeType',
        sortorder: "desc",
        /*  caption: i18n.MCI061229S10["codetype.codeList"],*/
        height: 200,
        onSelectRow: function(){
            var ret = grid.getSelRowDatas();
            ret && mform.injectData(ret);
        }
    });
//    var fModify = function(){
//    
//    }
	$("#qry").click(function(){
		grid.jqGrid('setGridParam',{
			postData:{
				locale:mform.find("#locale").val(),codeType:mform.find("#codeType").val()}});
		grid.trigger("reloadGrid");
	});
    //新增
    $("#add").click(function(){
    	mform.validationEngine('validate') &&
    	API.showConfirmMessage(i18n.def.actoin_001,function(data){
    		data && $.ajax({
            url: "webroot/handler/codetypehandler/modify",
            data: $.extend(mform.serializeData(), {
                type: "A"
            }),
            success: function(){
                grid.trigger("reloadGrid");
            }
        });
    	});
    });
    //修改
    $("#modify").click(function(){
        if (grid.getSelRowDatas()) {
        	mform.validationEngine('validate') &&
        	API.showConfirmMessage(i18n.def.actoin_001,function(data){
        		data &&  $.ajax({
                url: "webroot/handler/codetypehandler/modify",
                data: $.extend(mform.serializeData(), {
                    type: "M"
                }),
                success: function(){
                    grid.trigger("reloadGrid");
                }
            });
        	});
        }
        else {
            API.showErrorMessage(i18n.def.grid_selector);
        }
    });
    //删除
    $("#delete").click(function(){
        if (grid.getSelRowDatas()) {
        	API.showConfirmMessage(i18n.def.actoin_001,function(data){
        		data &&  $.ajax({
                url: "webroot/handler/codetypehandler/delete",
                data: {
                    oid: $("#oid").val()
                },
                success: function(){
                    grid.trigger("reloadGrid");
                }
            });
        });
        }
        else {
            API.showErrorMessage(i18n.def.grid_selector);
        }
        
    });
    //清除
    $("#clear").click(function(){
        mform.reset();
        grid.resetSelection();
    });
});