<#import "parts/common.ftlh" as c>
<#import "parts/modifyCommon.ftlh" as modify>
<@c.page>
    <@modify.modify"/addproject",true,true/>
    <div>
    <table border="1">
    <thead>
    <tr>
        <td>Full Name</td>
        <td></td>
    </tr>
    </thead>
        <tbody>
        <#list allemployees as employee>
        <tr>
            <td>${employee.fullName}</td>
            <td><label><input name="${employee.fullName}" type="checkbox"
                            ${myemployees?seq_contains(employee)?string("checked","")}>
                </label></td>
        </tr>
        </tbody>
        </#list>
    </table>
    </div>
    <button type="submit">Save</button>
    </form>
</@c.page>