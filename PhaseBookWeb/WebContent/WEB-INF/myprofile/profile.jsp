<%@ page import="phasebook.controller.*"%>
<%@ page import="javax.naming.*" %>
<%@ page import="phasebook.user.*" %>
<%@ page import="phasebook.post.*" %>
<%@ page import="java.util.*" %>

<% 
	PhasebookUserRemote userBean = Utils.getUserBean();
	PhasebookUser user;
	Object userId;
	if(request.getParameter("id") == null)
		userId =  session.getAttribute("id");
	else
		userId =  request.getParameter("id");
	if (request.getParameter("id") == null)
		user = userBean.getUserById(session.getAttribute("id"));
	else
	{
		try {
			Utils.getUserBean().getUserById(request.getParameter("id")).getName();
			user = userBean.getUserById(request.getParameter("id"));
		} catch (Exception e) {
			user = userBean.getUserById(session.getAttribute("id"));
		}
	}
%>

<h1><%= Utils.text(user.getName()) %></h1>

<p class="tip"><%= Utils.text(user.getEmail()) %></p>

<form method="POST" action="CreatePostForm">
	<table>
		<tr>
			<td><textarea name="text" COLS=80 ROWS=6></textarea></td>
			<td><input type="hidden" name="toUser" value="<%= userId.toString() %>"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Send" name="B1"></td>
		</tr>
	</table>
</form>
--------------------------------------------------------------------------------------------
<%
	List<Post> posts = userBean.getUserReceivedPosts(userId);
	for(int i=posts.size()-1; i>=0; i--){
%>
	<br>
    <%= posts.get(i).getText() %>
    <br>
    Posted by:
    <br>
    <%= posts.get(i).getFromUser().getName() %>
    <br>
--------------------------------------------------------------------------------------------
<%
	}
%>