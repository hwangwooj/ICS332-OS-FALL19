Homework Assignment #7 - Page Tables

			<Exercise #1: Address Translation>

a.2020

2020 = (2048 * 0) + 2020    => page number : 0 
			       frame number : 12 (according to the page table)
			       offset : 2020

Therefore, physical address = (2048 * 12) + 2020 = 26596


b.12540

12540 = (2048 * 6) + 252   =>  page number : 6 
			       frame number : 2 (according to the page table)
			       offset : 252

Therefore, physical address = (2048 * 2) + 252 = 4348


c.8150

8150 = (2048 * 3) + 2006   =>  page number : 3 
			       frame number : 6 (according to the page table)
			       offset : 2006

Therefore, physical address = (2048 * 6) + 2006 = 14294


d.22540

22540 = (2048 * 11) + 12   =>  page number : 11 
			       frame number : 31 (according to the page table)
			       offset : 12

Therefore, physical address = (2048 * 31) + 12 = 63500

e.20484

20484 = (2048 * 10) + 4     => page number : 10
			       frame number: 10 does not have a frame number

Therefore, 20484 will generate an error
************************************************************************************


		   <Exercise #2: Logical and Physical address size>

a.How many bits are required in the logical address? (show your work)

4096 = 2^12
16 pages = 2^4 pages

2^12 * 2^4 = 2^16

Therefore, 16 bits are required in the logical address.


b.How many bits are required in the physical address? (show your work)

4096 = 2^12
8 frames = 2^3 frames

2^12 * 2^3 = 2^15

Therefore, 15 bits are required in the logical address.
************************************************************************************


			    <Exercise #3: Page table size>

a.How many entries are there in a conventional single-level page table for
a process that would use the maximum possible address space? (show your work)

64-bit logical addresses => 2^64 address space
2-KiB page/frame size => 2^11 bytes per page/frame size

2^64 / 2^11 = 2^53

2^53 entries are there.


b.How many entries are there in an inverted page table? (show your work)

4GiB of physical memory => 2^2 * 2^30 = 2^32
2-KiB page/frame size => 2^11 bytes per page/frame size

2^32 / 2^11 = 2^21

2^21 entries are there.

************************************************************************************


			 <Exercise #4: Page table structure>

a.How many pages are in the logical address space for a process
that uses the largest possible address space? (show your work)

44-bit logical addresses => 2^44
page size of 64KiB => 2^6 * 2^10 = 2^16

2^44 / 2^16 = 2^28

Therefore, there are 2^28 pages in the logical address space.

b.Suppose we use two-level paging and arrange for all page tables to fit into a single page frame. How will the bits of the address be divided up? (show your work)

2^16 page size / 2^2 bytes per page table entry = 2^14 entries per page

Therefore, 44-bit logical addresses will be divided into 16 bits(page size), 14 bits(outer page table bits), and 14(44-16-14 = 14, which is inner page table bits). 


