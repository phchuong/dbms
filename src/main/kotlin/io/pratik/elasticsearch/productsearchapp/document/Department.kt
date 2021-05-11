package io.pratik.elasticsearch.productsearchapp.document

class Department {
    var id: Long? = null
    var name: String? = null

    constructor() {}
    constructor(id: Long?, name: String?) {
        this.id = id
        this.name = name
    }

    override fun toString(): String {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}'
    }
}