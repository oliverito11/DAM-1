<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                
                <!-- Título -->
                <h1>Ejercicio 1.5</h1>

                <!-- Tabla -->
                <table border="1">

                    <!-- Cabecera -->
                    <tr bgcolor="#9acd32">
                        <th>Provincia</th>
                        <th>T 2020</th>
                    </tr>

                    
                    <xsl:for-each select="poblacion/provincia">
                        <!-- Ordenar por Total2020 de manera descendente -->
                        <xsl:sort select="Total2020" data-type="number" order="descending"/>
                        <tr>
                            <!-- Se mostrarán las provincias y su población total con un color dependiendo de su valor -->
                            <td><xsl:value-of select="nombre" /></td>
                            <xsl:choose>
                                
                                <!-- Si es mayor que 500000 -->
                                <xsl:when test="Total2020 &gt; 500000">
                                    <td bgcolor="green">
                                        <xsl:value-of select="Total2020" />
                                    </td>
                                </xsl:when>
                                
                                <!-- Si es mayor que 200000 -->
                                <xsl:when test="Total2020 &gt; 200000">
                                    <td bgcolor="yellow">
                                        <xsl:value-of select="Total2020" />
                                    </td>
                                </xsl:when>

                                <!-- En caso contrario... -->
                                <xsl:otherwise>
                                    <td bgcolor="red">
                                        <xsl:value-of select="Total2020" />
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