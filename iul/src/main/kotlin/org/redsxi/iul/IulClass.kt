package org.redsxi.iul

import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes.*

open class IulClass(val name: String) {
    open fun superClass() = "java/lang/Object"

    open fun generateClassInside(writer: ClassWriter) {
        // WOW
    }

    fun generate(): ByteArray {
        val writer = ClassWriter(0)
        writer.visit(
            V17,
            ACC_PUBLIC or ACC_SUPER,
            name,
            null,
            superClass(),
            null
            )
        writer.visitSource("IUL Generated", "Config class: $this")
        writer.visitAnnotation(
            "org/redsxi/iul/annos/IulGenerated",
            true
        ).visitEnd()

        generateClassInside(writer)

        writer.visitEnd()
        return writer.toByteArray()
    }
}