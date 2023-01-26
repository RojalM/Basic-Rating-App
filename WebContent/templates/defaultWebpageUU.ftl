<#include "header.ftl">

<b>Please Register</b><br><br>

<form method="POST" action="uugui?action=Register">
	<fieldset id="insertoffer">
		<legend>Required Information</legend>
		<div>
			<label>Username</label>
			<input type="text" name="username" required="required">
	    </div>

		<div>
			<label>Email</label>
			<input type="text" name="email" required="required">
	    </div>

		<div>
			<label>Age</label>
			<input type="text" name="age" required="required">
	    </div>
	</fieldset>
	<button type="submit" id="submit">Register</button>
</form>
<#include "footer.ftl">