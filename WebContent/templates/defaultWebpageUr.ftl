<#include "header.ftl">

<b>Please Rate</b><br><br>

<form method="POST" action="urgui?action=Rating">
	<fieldset id="rating">
		<legend>Required Information</legend>
		<div>
			<label>Username</label>
			<input type="text" name="username" required="required">
	    </div>
		<div>
			<label>Movie</label>
			<input type="text" name="movie" required="required">
	    </div>

		<div>
			<label>Rating</label>
			<input type="text" name="rating" required="required">
	    </div>
	    <div>
			<label>Comment (optional)</label>
			<input type="text" name="comment">
	    </div>
	</fieldset>
	<button type="submit" id="submit">Rate</button>
</form>
<#include "footer.ftl">