package com.ka2kama.core.todo.domain.repository.impl

import com.ka2kama.core.todo.domain.model.{Todo, TodoId}
import com.ka2kama.core.todo.domain.repository.TodoRepository
import scalikejdbc._

private[repository] class TodoRepositoryByScalikeJDBC extends TodoRepository {

  override def findAll: Seq[Todo] = DB readOnly { implicit session =>
    sql"select * from todo".map(TodoSupport.apply).list.apply()
  }

  override def findById(id: TodoId): Option[Todo] = DB readOnly {
    implicit session =>
      sql"select * from todo where id = ${id.value}"
        .map(TodoSupport.apply)
        .single
        .apply()
  }
}

private object TodoSupport extends SQLSyntaxSupport[Todo] {
  override val tableName = "todo"
  def apply(rs: WrappedResultSet): Todo =
    Todo(TodoId(rs.long("id")), rs.string("content"), rs.int("state"))
}
