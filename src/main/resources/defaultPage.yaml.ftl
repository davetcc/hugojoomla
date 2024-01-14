<#-- @ftlvariable name="joomlaData" type="com.thecoderscorner.web.hugojoomla.JoomlaContent" -->
---
title: "${joomlaData.title}"
description: "${joomlaData.metadesc}"
tags: [ ${tags} ]
type: "post"
date: "${joomlaData.createdDateAsText}"
lastmod: "${joomlaData.modifiedDateAsText}"
<#if joomlaData.author??>
author:  "${joomlaData.author}"
</#if>
<#if joomlaData.introImage.isImagePresent()>
banner: "${joomlaData.introImage.url}"
</#if>
<#if joomlaData.parent??>
menu: "${joomlaData.parent}"
</#if>
<#if !joomlaData.isPublished()>
draft: true
</#if>
---
<#if joomlaData.bodyImage.isImagePresent() >
    <img class="${joomlaData.bodyImage.htmlClass} titleimg" alt="${joomlaData.bodyImage.alt}" src="${joomlaData.bodyImage.url}"/>
</#if>
${body}
