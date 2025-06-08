<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
var menus = [{
	"backMenu": [{
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "用户信息",
			"menuJump": "列表",
			"tableName": "yonghu"
		}],
		"menu": "用户管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "实验室信息",
			"menuJump": "列表",
			"tableName": "shiyanshi"
		}],
		"menu": "实验室管理"
	}, {
		"child": [{
			"buttons": ["删除","同意","拒绝"],
			"menu": "申请信息",
			"menuJump": "列表",
			"tableName": "shenqing"
		}],
		"menu": "申请管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "轮播图管理",
			"tableName": "lunbotuguanli"
		},{
			"buttons": ["新增", "修改", "删除"],
			"menu": "新闻公告",
			"tableName": "news"
		},{
			"buttons": ["新增","修改","删除"],
			"menu": "留言板",
			"tableName": "liuyanbanguanli"
		}],
		"menu": "系统管理"
	}],
	"frontMenu": [],
	"hasBackLogin": "是",
	"hasBackRegister": "否",
	"hasFrontLogin": "否",
	"hasFrontRegister": "否",
	"roleName": "管理员",
	"tableName": "users"
},
{
	"backMenu": [{
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "实验室信息",
			"menuJump": "列表",
			"tableName": "shiyanshi"
		}],
		"menu": "实验室管理"
	}, {
		"child": [{
			"buttons": ["删除","同意","拒绝"],
			"menu": "申请信息",
			"menuJump": "列表",
			"tableName": "shenqing"
		}],
		"menu": "申请管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "新闻公告",
			"tableName": "news"
		},{
			"buttons": ["新增","修改","删除"],
			"menu": "留言板",
			"tableName": "liuyanbanguanli"
		}],
		"menu": "系统管理"
	}],
	"frontMenu": [],
	"hasBackLogin": "是",
	"hasBackRegister": "否",
	"hasFrontLogin": "否",
	"hasFrontRegister": "否",
	"roleName": "实验室管理员",
	"tableName": "yonghu"
}
,
{
	"backMenu": [{
		"child": [{
			"buttons": ["申请"],
			"menu": "实验室信息",
			"menuJump": "列表",
			"tableName": "shiyanshi"
		}],
		"menu": "实验室管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "申请信息",
			"menuJump": "列表",
			"tableName": "shenqing"
		}],
		"menu": "申请管理"
	}],
	"frontMenu": [],
	"hasBackLogin": "是",
	"hasBackRegister": "否",
	"hasFrontLogin": "否",
	"hasFrontRegister": "否",
	"roleName": "用户",
	"tableName": "yonghu"
}];

var hasMessage = '';
