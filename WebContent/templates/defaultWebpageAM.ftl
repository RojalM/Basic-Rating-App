<#include "header.ftl">

<b>Please add your Movie</b><br><br>

<form method="POST" action="liugui?action=addingMovie">
    <fieldset id="addingMovie">
        <legend>Required Information</legend>
        <div>
            <label>Titel</label>
            <input type="text" name="title" required="required">
        </div>

        <div>
            <label>Director</label>
            <input type="text" name="director"required="required">
        </div>

        <div>
            <label>Release (dd/mm/yyyy)</label>
            <input type="text" name="release" required="required">
        </div>

        <div>
            <label>Actor</label>
            <input type="text" name="actor"required="required">
        </div>
    </fieldset>
    <button type="submit" id="submit">Add</button>
</form>
<#include "footer.ftl">