<#macro cfb>
    <#list 1..9 as i>
        <#list 1..i as j>
            ${j}*${i}=${j*i}&nbsp;
        </#list>
        <br>
    </#list>
</#macro>
