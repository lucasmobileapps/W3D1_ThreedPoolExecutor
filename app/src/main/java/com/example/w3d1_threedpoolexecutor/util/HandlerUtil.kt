package com.example.w3d1_threedpoolexecutor.util

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.w3d1_threedpoolexecutor.MainActivity
import com.example.w3d1_threedpoolexecutor.model.MessageParcelable
import java.util.concurrent.*

object HandlerUtil {

    const val messageKey = "message_key"

    private const val MIN_POOL_COUNT = 3
    private const val MAX_POOL_COUNT = 5
    private const val TIME_LIMIT: Long = 30
    private val TIME_UNIT = TimeUnit.MINUTES
    private val taskQueue: BlockingQueue<Runnable> = LinkedBlockingQueue<Runnable>()

    lateinit var handler: Handler
    lateinit var taskList: MutableList<Runnable>
    var threadPoolExecutor: ThreadPoolExecutor? = null


    fun setProperties(handler: Handler, taskList: MutableList<Runnable>) {
        this.handler = handler
        this.taskList = taskList
    }

    fun executeTasksInThreadPool() {
        if (threadPoolExecutor == null)
            threadPoolExecutor =
                ThreadPoolExecutor(MIN_POOL_COUNT, MAX_POOL_COUNT, TIME_LIMIT, TIME_UNIT, taskQueue)

        taskList.forEach { currentTask ->

            threadPoolExecutor?.execute(currentTask)
        }
    }

    fun sendMessage(message: String){
        val messageParcelable = MessageParcelable(message)
        val msg = Message()

        val bundle = Bundle()
        bundle.putParcelable(messageKey, messageParcelable)
        msg.data = bundle

        handler.sendMessage(msg)

    }


}