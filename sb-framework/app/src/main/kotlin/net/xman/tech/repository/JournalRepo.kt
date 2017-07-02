package net.xman.tech.repository

import net.xman.tech.common.domain.Journal
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*
import org.springframework.data.jpa.repository.Query
import org.springframework.data.querydsl.QueryDslPredicateExecutor


/*
* TODO: Repository方法名定义参考:
* http://docs.spring.io/spring-data/jpa/docs/1.11.4.RELEASE/reference/html/#jpa.query-methods.query-creation
* http://docs.spring.io/spring-data/jpa/docs/1.11.4.RELEASE/reference/html/#repositories.query-methods.query-creation
*
* 使用存储过程：
* http://docs.spring.io/spring-data/jpa/docs/1.11.4.RELEASE/reference/html/#jpa.stored-procedures
*
*
* find…By, read…By, query…By, count…By, and get…By
*
* 
*  Table 4. Supported keywords inside method names 
*  
*  Keyword 	Sample 	JPQL snippet
And
findByLastnameAndFirstname
… where x.lastname = ?1 and x.firstname = ?2

Or
findByLastnameOrFirstname
… where x.lastname = ?1 or x.firstname = ?2

Is,Equals
findByFirstname,findByFirstnameIs,findByFirstnameEquals
… where x.firstname = ?1

Between
findByStartDateBetween
… where x.startDate between ?1 and ?2

LessThan
findByAgeLessThan
… where x.age < ?1

LessThanEqual
findByAgeLessThanEqual
… where x.age <= ?1

GreaterThan
findByAgeGreaterThan
… where x.age > ?1

GreaterThanEqual
findByAgeGreaterThanEqual
… where x.age >= ?1

After
findByStartDateAfter
… where x.startDate > ?1

Before
findByStartDateBefore
… where x.startDate < ?1

IsNull
findByAgeIsNull
… where x.age is null

IsNotNull,NotNull
findByAge(Is)NotNull
… where x.age not null

Like
findByFirstnameLike
… where x.firstname like ?1

NotLike
findByFirstnameNotLike
… where x.firstname not like ?1

StartingWith
findByFirstnameStartingWith
… where x.firstname like ?1 (parameter bound with appended %)

EndingWith
findByFirstnameEndingWith
… where x.firstname like ?1 (parameter bound with prepended %)

Containing
findByFirstnameContaining
… where x.firstname like ?1 (parameter bound wrapped in %)

OrderBy
findByAgeOrderByLastnameDesc
… where x.age = ?1 order by x.lastname desc

Not
findByLastnameNot
… where x.lastname <> ?1

In
findByAgeIn(Collection<Age> ages)
… where x.age in ?1

NotIn
findByAgeNotIn(Collection<Age> age)
… where x.age not in ?1

True
findByActiveTrue()
… where x.active = true

False
findByActiveFalse()
… where x.active = false

IgnoreCase
findByFirstnameIgnoreCase
… where UPPER(x.firstame) = UPPER(?1)

In and NotIn also take any subclass of Collection as parameter as well as arrays or varargs. For other syntactical versions of the very same logical operator check Repository query keywords.
*
* */

interface JournalRepo : JpaRepository<Journal, Long> /* ,QueryDslPredicateExecutor<Journal> */ {
    fun findByCreatedAfter(date: Date): List<Journal>

    fun findByTitle(title: String): List<Journal>

    fun findTop2ByTitle(title: String): List<Journal>

    fun findFirst2ByTitleOrderByIdDesc(title: String): List<Journal>

    // The @Query annotation accepts the JPQL syntax.
    @Query("select j from Journal j where j.title like %?1%")
    fun findByCustomQuery(word: String): List<Journal>
}
