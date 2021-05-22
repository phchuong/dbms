

package io.demo.productsearchapp
import org.springframework.web.bind.annotation.*

import io.demo.productsearchapp.entities.MovieTime
import io.demo.productsearchapp.entities.BillDetail
import io.demo.productsearchapp.entities.Bill


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MoveTimeRepository : JpaRepository<MovieTime, Long>{
}


@Repository
interface BillDetailRepository : JpaRepository<BillDetail, Long>{

}

@Repository
interface BillRepository : JpaRepository<Bill, Int>{
}


@RestController
@RequestMapping("/movietime")
class MovieTimeController(private val movietimeRepository: MoveTimeRepository,private val billRepository: BillRepository,private val billtailRepository: BillDetailRepository) {
   
    @GetMapping("/detail/{id}")
    fun schedule(@PathVariable id: Int): Collection<MovieTime>? {
        println("id:"+id);
		val movieTime = movietimeRepository.findAll();
        // movieTime = movieTime.filterIndexed{index,s-> s.id == id}
        return movieTime;
    }

	@GetMapping("/seat/{id}")
    fun getSeat(@PathVariable id: Int): Collection<BillDetail>? {
        println("id:"+id);
		val billdetail = billtailRepository.findAll();
        // var s = billdetail.filterIndexed{index,s-> s.id_schedulder == id}
		// println(s);
        return billdetail;
    }
	
	//  
    @PostMapping("/payment")
    fun payment(@RequestBody bill: Bill): Bill {
      
        bill.total_price = bill.unit_price*bill.seats.size - bill.discount;
        billRepository.save(bill)
        bill.seats.forEach{it.id_bill=bill.id}
        billtailRepository.saveAll(bill.seats)
        return bill;
    }

    @GetMapping("/bill/{id}")
    fun bill(@PathVariable id: Int): Bill {
        var bill = billRepository.getOne(id);
        return bill;
    }
}




