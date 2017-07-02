package net.xman.tech.common.domain

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Transient

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import net.xman.tech.common.util.JsonDateSerializer

@Entity
class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var title: String? = null

    @get:JsonSerialize(using = JsonDateSerializer::class)
    var created: Date? = null

    var summary: String? = null

    constructor() {}

    @Transient
    private val format = SimpleDateFormat("MM/dd/yyyy")

    @Throws(ParseException::class)
    constructor(title: String, summary: String, date: String) {
        this.title = title
        this.summary = summary
        this.created = format.parse(date)
    }

    constructor(id: Long?, title: String, summary: String, date: Date) {
        this.id = id
        this.title = title
        this.summary = summary
        this.created = date
    }

    val createdAsShort: String
        @JsonIgnore
        get() = format.format(created)

    override fun toString(): String {
        return "Journal [id=$id, title=$title, created=$created, summary=$summary]"
    }

}