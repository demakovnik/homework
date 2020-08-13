<#macro modify path isEditForm isForProject>
    <form method="post" action="${path}">
        <#if isForProject>
            <input name="projectId" type="hidden" value="${project.id?if_exists}">
            <label>Project Title<input value="${project.title}" name="projectTitle" type="text"></label>
            <#else>
                <input name="employeeId" type="hidden" value="${employee.id?if_exists}">
                <label>Full Name<input value="${employee.fullName}" name="fullName" type="text"></label>
        </#if>


</#macro>