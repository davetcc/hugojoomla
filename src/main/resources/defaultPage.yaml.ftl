<#-- @ftlvariable name="joomlaData" type="com.thecoderscorner.web.hugojoomla.JoomlaContent" -->
---
title: "${joomlaData.title}"
description: "${joomlaData.metadesc}"
tags: [ ${tags} ]
type: "post"
date: "${joomlaData.modifiedDateAsText}"
author:  "${joomlaData.author}"
<#if joomlaData.introImage.isImagePresent()>
banner: "${joomlaData.introImage.url}"
</#if>
menu: "${joomlaData.parent}"
---
<#if joomlaData.bodyImage.isImagePresent() >
    <img class="${joomlaData.bodyImage.htmlClass} titleimg" alt="${joomlaData.bodyImage.alt}" src="${joomlaData.bodyImage.url}"/>
</#if>
${body}
