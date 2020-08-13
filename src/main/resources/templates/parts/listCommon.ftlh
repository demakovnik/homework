<#macro list path isProject>
<div>
    <form method="get" action="${path}">
        <#if isProject>
            <input type="hidden" name="projectId">
            <button type="submit">Add project</button>
        <#else>
            <input type="hidden" name="employeeId">
            <button type="submit">Add employee</button>
        </#if>
    </form>
</div>
<div>
    <#if isProject>
        Project List:
    <#else>
        Employee List:
    </#if>


    <div>
    <table border="1">
        <thead>
        <tr>
            <td><#if isProject>
                    Project Title:
                <#else>
                    Full Name:
                </#if></td>
            <td></td>
            <td></td>
        </tr>
        </thead>

        </#macro>
