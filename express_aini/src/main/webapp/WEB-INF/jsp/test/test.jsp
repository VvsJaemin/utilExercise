<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/jstl.jsp"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <title>test111</title>
    <style>
        table {
            width:100%;
            border:1px solid;
        }
        td {
            border:1px solid
        }
    </style>
</head>
<body>
    <table>
	    <c:forEach items="${list }" var="test" varStatus="status">
	    <tr>
	        <td>${test.no}</td>
	        <td>${test.exp_not_region}</td>
	        <td>${test.exp_set_region}</td>
	        <td>${test.exp_add_price_region}</td>
	        <td>${test.set_cost}</td>
	        <td>${test.set_item_cate}</td>
	        <td>${test.order_list_num}</td>
	        <td>${test.exp_order_list_num}</td>
	        <td>${test.claim_order_list_num}</td>
	        <td>${test.account_list_num}</td>
	        <td>${test.exp_noship_order_list_num}</td>
	        <td>${test.put_order_list_num}</td>
	        <td>${test.rs_order_insert_list_num}</td>
	        <td>${test.nomatch_colors}</td>
	        <td>${test.order_filter_filed}</td>
	        <td>${test.order_filter_key}</td>
	        <td>${test.order_claim_status}</td>
	        <td>${test.order_claim_last_id}</td>
	        <td>${test.sms_use}</td>
	        <td>${test.sms_type}</td>
	        <td>${test.sms_icode_id}</td>
	        <td>${test.sms_icode_pw}</td>
	        <td>${test.sms_icode_server_ip}</td>
	        <td>${test.sms_icode_server_port}</td>
	        <td>${test.sms_default_phone}</td>
	        <td>${test.xls_limit}</td>
	    </tr>
	    </c:forEach>
    </table>
</body>
</html>
