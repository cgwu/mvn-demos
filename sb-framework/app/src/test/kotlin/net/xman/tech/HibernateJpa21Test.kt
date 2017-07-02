package net.xman.tech

import net.xman.tech.common.domain.Journal
import net.xman.tech.repository.JournalRepo
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.Example
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest
class HibernateJpa21Test {
    private val log = LoggerFactory.getLogger(HibernateJpa21Test::class.java)

    @Autowired
    private val journalRepo: JournalRepo? = null

    @Test
    @Throws(Exception::class)
    fun testJournalRepo() {
        log.info("测试Journal Repo开始")
        // 查找所有,按默认
        var list = journalRepo!!.findAll()
        list.forEach { println(it) }
        Assert.assertTrue(list.count() > 0)

        println("----------- all")
        // 查找所有,指定排序
//        list = journalRepo!!.findAll(Sort(Sort.Direction.DESC,"id","title"))
        var orders = listOf(
                Sort.Order(Sort.Direction.ASC, "title"),
                Sort.Order(Sort.Direction.DESC, "id")
        )
        list = journalRepo!!.findAll(Sort(orders))
        list.forEach { println(it) }

        println("----------- by ids")
        //按多个ID查找
        list = journalRepo!!.findAll(listOf(505L, 516L))
        list.forEach { println(it) }

        println("----------- by example")
        var journal = Journal()
        journal.title = "Spring Boot Reading"
        list = journalRepo!!.findAll(Example.of(journal))
        list.forEach { println(it) }

        println("----------- by paging")
        var pageResult = journalRepo!!.findAll(PageRequest(1, 3))
        pageResult.forEach { println(it) }
        println("页数从0开始")
        pageResult = journalRepo!!.findAll(PageRequest(0, 3, Sort.Direction.DESC, "id"))
        pageResult.forEach { println(it) }

        println("----------- 自定义方法")
        list = journalRepo!!.findByTitle("Simple Spring Boot Project")
        list.forEach { println(it) }

        println("----------- 自定义方法 top 2")
        list = journalRepo!!.findTop2ByTitle("Spring Boot in the Cloud")
        list.forEach { println(it) }

        println("----------- 自定义方法 top 2 order by id")
        list = journalRepo!!.findFirst2ByTitleOrderByIdDesc("Spring Boot in the Cloud")
        list.forEach { println(it) }

        println("----------- 自定义query")
        list = journalRepo!!.findByCustomQuery("Simple")
        list.forEach { println(it) }



        log.info("测试Journal Repo结束")
    }
}