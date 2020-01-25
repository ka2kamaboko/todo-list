package com.ka2kama.todolist.core.db.todo

import com.ka2kama.todolist.core.db.todo.dao._
import net.codingwell.scalaguice.ScalaPrivateModule

private[core] final class TodoDaoModule extends ScalaPrivateModule {
  override def configure(): Unit = {
    bind[TodoDao].to[TodoDaoByAnorm]
//    bind[TodoDao].to[TodoDaoByMongoDB]
//    bind[TodoDao].to[TodoDaoByScalikeJDBC]
//    bind[TodoDao].to[TodoDaoBySlick]
//    bind[TodoDao].to[TodoDaoOnMemory]

    expose[TodoDao]

    ()
  }
}
