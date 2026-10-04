package org.redsxi.iul

class IulConfig(
    val classes: MutableMap<String, IulClass> = HashMap(),
) {

    private var parent: IulConfig? = null

    constructor(p: IulConfig) : this() {
        parent = p
    }

    fun child() = IulConfig(this)

    fun merge(another: IulConfig) = IulConfig(
        HashMap(classes + another.classes)
    )

    fun addClass(name: String): IulClass {
        val clazz = IulClass(name)
        classes[name] = clazz
        return clazz
    }

    fun addClass(clazz: IulClass) {
        classes[clazz.name] = clazz
    }

    fun forEachClasses(func: (IulClass) -> Unit) {
        classes.values.forEach(func)
        parent?.classes?.values?.forEach(func)
    }
}