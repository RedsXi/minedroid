package org.redsxi.iul

class IulClassLoader(
    val config: IulConfig,
    parent: ClassLoader? = null
): ClassLoader(parent) {
    override fun findClass(name: String): Class<*>? {
        val clazz = config.classes[name]
        val bytes = clazz?.generate()
        return bytes?.let {
            defineClass(null, bytes, 0, bytes.size)
        }
    }
}