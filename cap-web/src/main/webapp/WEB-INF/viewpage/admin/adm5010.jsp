<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
<meta name="decorator" content="none">
<title><spring:message code="adm5010.title"><!--參數設定--></spring:message></title>
</head>
<body>
	<script>
		loadScript('js/admin/adm5010');
	</script>
	<div>
		<div class="btns">
			<button id="qry" type="button" class="btn1">
				<spring:message code="btn.query">
					<!--查詢-->
				</spring:message>
			</button>
			<button id="detail" type="button" class="btn1">
				<spring:message code="btn.detail">
					<!--操作資料內容-->
				</spring:message>
			</button>
		</div>
		<div id="gridview"></div>
		<!-- dialog start-->
						<!--Start : 查詢-->
						<div id="SEARCH" style="display:none">
                <form id="searchForm" name="searchForm">
                    <table class="tb2" width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                            <tr>
                                <td width="20%" class="hd1">序號</td>
                                <td colspan="1">
                                    <input type="text" size="15" id="sno">
                                </td>
                                <td width="20%" class="hd1">員工編號</td>
                                <td width="30%">
                                    <input type="text" size="15" id="userId" maxlength="6">
                                </td>
                            </tr>
                            <tr>
                                <td width="20%" class="hd1">記錄日期</td>
                                <td width="30%">
                                    <input type="text" size="15" id="sdate" class="date">
                                </td>
                                <td width="20%" class="hd1" nowrap="true">記錄時間(時:分)</td>
                                <td width="30%">
                                    <input type="text" size="8" id="time" maxlength="8"/>(以後)</td>
                            </tr>
                            <!-- 
                            <tr>
                                <td width="20%" class="hd1">系統代碼</td>
                                <td width="30%"  colspan="3">
                                    <select id="brekFlag" name="brekFlag">
                                        <option value="1">COL</option>
                                        <option value="2">CES</option>
                                        <option value="3">DEB</option>
                                        <option value="4">SNR</option>
                                    </select>
                                </td>
                            </tr>
                             -->
                            <tr>
                                <td width="20%" class="hd1">文件序號</td>
                                <td width="30%" colspan="3">
                                    <input type="text" size="50" id="mainId" maxlength="32"/>
                                </td>
                            </tr>
                            <tr>
                                <td width="20%" class="hd1">事件對象</td>
                                <td width="30%" colspan="3">
                                    <input type="text" size="50" id="invokeTarget" maxlength="100"/>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
            <div id="DETAIL" style="display:none">
                <fieldset>
                    <legend>輸入</legend>
                    <textarea id="data" rows="7" cols="63">
                    </textarea>
                </fieldset>
                <fieldset>
                    <legend>輸出</legend>
                    <textarea id="data" rows="7" cols="63">
                    </textarea>
                </fieldset>
            </div>
						<!-- dialog end-->
	</div>
</body>
</html>