<#include "header.ftl">

<b></b>

<table id="Movies">
	<tr>
		<th>Titel</th>
		<th>Ver�ffentlichungsdatum</th>
		<th>Direktor</th>
		<th>Hauptdarsteller</th>
		<th>Rating</th>
		<th>comment</th>
	</tr>
	<#list Movies as mo>
	<tr>
		<td><a href="usgui?action=Movielist title="MovieList"</a></td>
		<td>${mo.titel}</td>
		<td>${mo.Ver�ffentlichungsdatum}</td>
		<td>${mo.Direktor}</td>
		<td>${mo.Hauptdarsteller}</td>
		<td>${mo.Rating}</td>
		<td>${mo.comment}</td>
	</tr>
	</#list>
</table>
<#include "footer.ftl">