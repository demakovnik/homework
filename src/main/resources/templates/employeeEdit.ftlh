<#import "parts/common.ftlh" as c>
<#import "parts/modifyCommon.ftlh" as modify>
<@c.page>
    <@modify.modify"/addemployee",true,false/>
    <button type="submit">Save</button>
    </form>
</@c.page>