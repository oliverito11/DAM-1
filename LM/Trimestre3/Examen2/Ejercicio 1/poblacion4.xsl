<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <!-- Título -->
                <h1>Ejercicio 1.4</h1>

                <!-- Tabla -->
                <table border="1">

                    <!-- Cabecera -->
                    <tr bgcolor="#9acd32">
                        <th>Provincia</th>
                        <th>T 2020</th>
                        <th>H 2020</th>
                        <th>M 2020</th>
                    </tr>

                    <xsl:for-each select="poblacion/provincia">
                        <!-- Se ordenan los valores de manera descendente de Total2020 -->
                        <xsl:sort select="Total2020" data-type="number" order="descending"/>
                        <!-- Se mostrarán solo aquellas provincias y su población (T, H, M) del 2020 si esta es mayor de 700000 -->
                        <xsl:if test="Total2020 &gt; 700000">
                            <tr>
                                <td><xsl:value-of select="nombre" /></td>
                                <td><xsl:value-of select="Total2020" /></td>
                                <td><xsl:value-of select="Hombres2020" /></td>
                                <td><xsl:value-of select="Mujeres2020" /></td>
                            </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>