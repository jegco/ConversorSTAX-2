<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="html" version="1.0" encoding="UTF-8"/>

<xsl:template match="/">
<XMI xmi.version="1.1" xmlns:UML="omg.org/UML1.3" timestamp="2014-10-26 16:07:19">
	<XMI.header>
		<XMI.documentation>
			<XMI.exporter>Conversor STAX-2</XMI.exporter>
			<XMI.exporterVersion>1.0</XMI.exporterVersion>
		</XMI.documentation>
        </XMI.header>

	<XMI.content>	
	<xsl:for-each select="graph">
		<header><xsl:value-of select="@type"/></header>
		<xsl:for-each select="class">
			<div>
				<span><xsl:value-of select="@name"/></span>
				<div>
					<xsl:for-each select="attributes/attribute">
						<span>
							<xsl:value-of select="@name"/>:
							<xsl:value-of select="@type"/>
						</span><br/>
					</xsl:for-each>
				</div>
				<div>
					<xsl:for-each select="methods/method">
						<span>
							<xsl:value-of select="@name"/>(
							<xsl:for-each select="parameters/parameter">
								<span>
									<xsl:value-of select="@name"/>:
									<xsl:value-of select="@return"/>
								</span>
							</xsl:for-each>
							)
							:<xsl:value-of select="@return"/>
						</span><br/>
					</xsl:for-each>
				</div>
			</div><br/><br/>
		</xsl:for-each>
	</xsl:for-each>
        </XMI.content>
</XMI>	
</xsl:template>

</xsl:stylesheet>