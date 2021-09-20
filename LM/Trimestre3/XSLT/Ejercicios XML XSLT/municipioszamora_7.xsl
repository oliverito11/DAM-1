<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
    <html>
        <body>
            <h2>Población municipios Zamora. Ordenados por población en orden decreciente</h2>
            <table border="1">
                <tr bgcolor="#9acd32">
                    <th>Municipio</th>
                    <th>Año 2020</th>
                </tr>
                <xsl:for-each select="tabla/municipio">
                    <xsl:sort select="a2020" data-type="number" order="descending" />
                    <tr>
                        <td><xsl:value-of select="nombre" /></td>
                        <xsl:choose>
                            <xsl:when test="a2020 &gt; 5000">
                                <td bgcolor="green">
                                    <xsl:value-of select="a2020" />
                                </td>
                            </xsl:when>
                            <xsl:when test="a2020 &gt; 1000">
                                <td bgcolor="yellow">
                                    <xsl:value-of select="a2020" />
                                </td>
                            </xsl:when>
                            <xsl:otherwise>
                                <td bgcolor="red">
                                    <xsl:value-of select="a2020" />
                                </td>
                            </xsl:otherwise>
                        </xsl:choose>
                    </tr>
                </xsl:for-each>
            </table>
        </body>
    </html>
</xsl:template>
</xsl:stylesheet>