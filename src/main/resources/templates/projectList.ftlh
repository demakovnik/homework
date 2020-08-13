<#import "parts/common.ftlh" as c>
<#import "parts/listCommon.ftlh" as list>
<@c.page>
    <@list.list "/addproject", true/>
    <tbody>
    <#list items as project>
        <tr>
            <td>${project.title}</td>

            <td>
                <form method="get" action="/project/${project.id}">
                    <input type="hidden" name="projectId" value="${project.id}">
                    <#--<input type="hidden" name="_csrf" value="${_csrf.token}">-->
                    <button type="submit">Edit</button>
                </form>
            </td>
            <td>
                <form method="get" action="/project/delete">
                    <input type="hidden" name="projectId" value="${project.id}">
                    <#--<input type="hidden" name="_csrf" value="${_csrf.token}">-->
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
        </tbody>
    <#else>
        No messages
    </#list>
    </table>
    </div>
</@c.page>