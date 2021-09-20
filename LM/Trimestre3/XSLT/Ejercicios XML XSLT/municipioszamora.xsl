<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
    <html>
        <body>
            <h2>Población municipios Zamora</h2>
            <table border="1">
                <tr bgcolor="#9acd32">
                    <th>Municipio</th>
                    <th>Año 2020</th>
                </tr>
                <xsl:for-each select="tabla/municipio">
                    <tr>
                        <td><xsl:value-of select="nombre" /></td>
                        <td><xsl:value-of select="a2020" /></td>
                    </tr>
                </xsl:for-each>
            </table>
        </body>
    </html>
</xsl:template>
</xsl:stylesheet>