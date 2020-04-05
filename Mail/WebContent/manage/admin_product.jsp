<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    <!--使用JSTL表达式。prefix设置使用的前缀，url路径要与jstl的jar包下的c.tld中uri一致  -->
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">产品管理</span></div>
        </div>
       
        <div class="result-wrap">
            <form action="/Mail/manage/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/Mail/manage/admin_toproductadd"><i class="icon-font"></i>新增产品</a>
                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="80%">
                        <tr>                         
                            <th>ID</th>
                            <th>商品名称</th>
                            <th>商品名称</th>                       
                        </tr>
                        
                        <c:forEach var="p" items="${plist}" >
                        	<tr>
                        		<td>${p.PRODUCT_ID }</td>
                        		<td>
                        			<img src="../images/product/${p.PRODUCT_FILENAME }" width="80px" height="80px">
                        			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${p.PRODUCT_NAME }
                        		</td>
                        		<td>
                        			<a href="">修改</a>
                        			<a href="">删除</a>
                        		</td>
                        	</tr>
						</c:forEach>
						
						<script>
							function catedel(id){
								if(confirm("你确定要删除这个分类吗？")){
									location.href="admin_docatedel?id="+id;
								}
							}
							

						</script>                        
                    </table>                  
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>