<#import "parts/common.ftlh" as c>
<#import "parts/modifyCommon.ftlh" as modify>
<@c.page>
    <@modify.modify "/addproject",false,true/>
    <button type="submit">Save</button>
    </form>
    <#if message?exists>
        <div class="alert alert-danger" role="alert">
            ${message?if_exists}
        </div>
    </#if>
</@c.page>