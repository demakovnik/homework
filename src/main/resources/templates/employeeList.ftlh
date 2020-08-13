<#import "parts/common.ftlh" as c>
<#import "parts/listCommon.ftlh" as list>
<@c.page>
    <@list.list "/addemployee", false/>
    <tbody>
    <#list items as employee>
        <tr>
            <td>${employee.fullName}</td>

            <td>
                <form method="get" action="/employee/${employee.id}">
                    <input type="hidden" name="employeeId" value="${employee.id}">
                    <#--<input type="hidden" name="_csrf" value="${_csrf.token}">-->
                    <button type="submit">Edit</button>
                </form>
            </td>
            <td>
                <form method="get" action="/employee/delete">
                    <input type="hidden" name="employeeId" value="${employee.id}">
                    <#--<input type="hidden" name="_csrf" value="${_csrf.token}">-->
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
        </tbody>
    </#list>
    </table>
    </div>
</@c.page>