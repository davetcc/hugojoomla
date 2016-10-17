<#-- @ftlvariable name="joomlaData" type="com.thecoderscorner.web.hugojoomla.JoomlaContent" -->
+++
title = "${joomlaData.title}"
description = "${joomlaData.introAsSingleLine}"
tags = [ ${tags} ]
date = "${joomlaData.createdDateAsText}"
categories = ["${joomlaData.category}"]
author =  "${joomlaData.author}"
+++
${body}