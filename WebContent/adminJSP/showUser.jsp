<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.maoyan.bean.*" import="java.util.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> - FooTable</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="shortcut icon" href="favicon.ico"> <link href="${pageContext.request.contextPath }/adminJSP/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/adminJSP/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/adminJSP/css/plugins/footable/footable.core.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/adminJSP/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/adminJSP/css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>所有订单</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <input type="text" class="form-control input-sm m-b-xs" id="filter"
                                   placeholder="搜索...">
                            <table class="footable table table-stripped" data-page-size="8" data-filter=#filter>
                                <thead>
                                        <tr>
                                            <th>订单ID</th>
                                            <th>电影名字</th>
                                            <th>电影院名字</th>
                                            <th>下单时间</th>
                                            <th>用户名</th>
                                            <th>价格</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    
                                    <c:forEach var="order" items="${ORDER_LIST }">
                                        <tr class="gradeX">
                                            <td>${order.orderId }</td>
                                            <td>${order.movieId }</td>
                                            <td>${order.cinemaId }</td>
                                            <td class="center">${order.time }</td>
                                            <td class="center">${order.userPhone }</td>
                                            <td class="center">${order.number }</td>
                                            <td class="center"><button>删除</button></td>
                                        </tr>
									</c:forEach>
                           </tbody>
                                    <tfoot>
                                        <tr>
                                            <td colspan="5">
                                                <ul class="pagination pull-right"></ul>
                                            </td>
                                        </tr>
                                    </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <!-- 全局js -->
    <script src="${pageContext.request.contextPath }/adminJSP/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath }/adminJSP/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath }/adminJSP/js/plugins/footable/footable.all.min.js"></script>
    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath }/adminJSP/js/content.js?v=1.0.0"></script>
    <script>
        $(document).ready(function() {
            $('.footable').footable();
            $('.footable2').footable();
        });
    </script>
</body>
</html>
