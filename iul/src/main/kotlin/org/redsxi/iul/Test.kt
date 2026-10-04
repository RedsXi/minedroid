package org.redsxi.iul

import java.io.FileOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val file = FileOutputStream("example.jar")
        val zip = ZipOutputStream(file)
        val config = Launcher.launch(IulConfig(), "org/redsxi/iul/Entry", "WPW", this::class.java.classLoader)
        config.addClass("test/Test")
        for (clazz: IulClass in config.classes.values) {
            zip.putNextEntry(ZipEntry("${clazz.name}.class"))
            zip.write(clazz.generate())
            zip.closeEntry()
        }
        zip.close()
        file.close()
    }
}