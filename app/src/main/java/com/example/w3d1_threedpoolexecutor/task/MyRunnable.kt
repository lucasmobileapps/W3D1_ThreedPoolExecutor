package com.example.w3d1_threedpoolexecutor.task

import android.os.Handler
import com.example.w3d1_threedpoolexecutor.util.HandlerUtil

class MyRunnable(val handler: Handler, val timeList: MutableList<Int>) : Runnable {

    override fun run() {
        val taskList :MutableList<Runnable> = mutableListOf()

        for(i in 0 until timeList.size){
            taskList.add(MyTask(timeList[i], i))
        }
        HandlerUtil.setProperties(handler, taskList)
        HandlerUtil.executeTasksInThreadPool()
    }

}