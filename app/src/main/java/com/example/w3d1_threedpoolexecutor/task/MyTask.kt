package com.example.w3d1_threedpoolexecutor.task

import com.example.w3d1_threedpoolexecutor.util.HandlerUtil

class MyTask(val countTime: Int, val position: Int) : Runnable {

    override fun run() {

        HandlerUtil.sendMessage("thread_name:Waiter ${position + 1}:$position")
        var time: Int = 0
        while (countTime > time) {

            time += 1
            HandlerUtil.sendMessage("thread_update:${countTime - time} Minutes remaining:${((time.toFloat() / countTime.toFloat()) * 100).toInt()}:$position")
            Thread.sleep(60000)
        }
        HandlerUtil.sendMessage("thread_done:$position")
    }
}