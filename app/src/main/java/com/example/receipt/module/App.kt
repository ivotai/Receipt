package com.example.receipt.module

import com.example.receipt.baseUrl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    single(named(baseUrl)) { "https://www.baidu.com/" }

}
