//package io.demo.productsearchapp.elasticsearch.document
//
//import org.springframework.data.annotation.Id
//import org.springframework.data.elasticsearch.annotations.Document
//import org.springframework.data.elasticsearch.annotations.Field
//import org.springframework.data.elasticsearch.annotations.FieldType
//
//@Document(indexName = "sample", type = "employee")
//class Employee {
//    @Id
//    var id: String? = null
//
//    @Field(type = FieldType.Object)
//    var organization: Organization? = null
//
//    @Field(type = FieldType.Object)
//    var department: Department? = null
//    var name: String? = null
//    var age = 0
//    var position: String? = null
//
//    override fun toString(): String {
//        return "Employee{" +
//                "id=" + id +
//                ", organization=" + organization +
//                ", department=" + department +
//                ", name='" + name + '\'' +
//                ", position='" + position + '\'' +
//                '}'
//    }
//}