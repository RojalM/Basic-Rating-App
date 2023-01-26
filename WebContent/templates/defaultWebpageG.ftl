<#include "header.ftl">

<b>Welcome to our little demonstration on the VR Webapp</b><br><br>

<form method="POST" action="UserGUI?action=getMovieList">
	<fieldset id="getMovieList">
		<legend>Movie List</legend>
		<div>
			<label>Do You wanna See Our Movies ? </label>
	    </div>
	    
	<button type="submit" id="SelectHOWebpage" name="SelectHOWebpage" value="Submit">Submit!</button>
</form>
<#include "footer.ftl">