package 栈和队列;

import java.util.LinkedList;
import java.util.Queue;

import javax.management.RuntimeErrorException;

import test.class_A;

public class 猫狗队列 {
	public static class Pet {
		private String type;
		public Pet(String type){
			this.type=type;
		}
		public String getPetType() {
			return this.type;
		}
	}
	public static class Dog extends Pet{
		public Dog() {
			super("dog");
		}
	}
	public static class Cat extends Pet{
		public Cat() {
			super("cat");
		}
	}
	public static class PetEnterQueue{
		private Pet pet;  //用户原有实例
		private long count; //时间戳
		public  PetEnterQueue(Pet pet,long count) {
			this.pet=pet;
			this.count=count;
		}
		
		public Pet getPet() {
			return this.pet;
		}
		public long getCount() {
			return this.count;
		}
		public String getEnterPetType() {
			return this.pet.getPetType();
		}
	}
	
	public static class CatDogQueue{
		private Queue<PetEnterQueue> dogQueue;
		private Queue<PetEnterQueue> catQueue;
		private long count;
		public CatDogQueue() {
			this.dogQueue=new LinkedList<猫狗队列.PetEnterQueue>();
			this.catQueue=new LinkedList<猫狗队列.PetEnterQueue>();
			this.count=0;
		}
		public void add(Pet pet) {
			if(pet.getPetType().equals("dog")) {
				this.dogQueue.add(new PetEnterQueue(pet, this.count++));
			}else if(pet.getPetType().equals("cat")) {
				this.catQueue.add(new PetEnterQueue(pet, this.count++));
			}else {
				throw new RuntimeException("err, not dog or cat");
			}
		}
		public Pet pollAll() {
			if(!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()) {
				if(this.dogQueue.peek().getCount()<this.catQueue.peek().getCount()) {
					return this.dogQueue.poll().getPet();
				}else {
					return this.catQueue.poll().getPet();
				}
			}else if(!this.dogQueue.isEmpty()) {
				return this.dogQueue.poll().getPet();
			}else if(!this.catQueue.isEmpty()) {
				return this.catQueue.poll().getPet();
			}else {
				throw new RuntimeException("err, queue is empty!");
			}
		}

		public boolean isEmpty() {
			return this.dogQueue.isEmpty() && this.catQueue.isEmpty();
		}
		
		public boolean isDogQueueEmpty() {
			return this.dogQueue.isEmpty();
		}
		public boolean isCatQueueEmpty() {
			return this.catQueue.isEmpty();
		}
		public Dog pollDog() {
			if(!this.isDogQueueEmpty()) {
				return (Dog)this.dogQueue.poll().getPet();
			}else {
				throw new RuntimeException("err, dogqueue is empty!");
			}
		}
		public Cat pollCat() {
			if(!this.isCatQueueEmpty()) {
				return (Cat)this.catQueue.poll().getPet();
			}else {
				throw new RuntimeException("err, catqueue is empty!");
			}
		}
	}

	public static void main(String[] args) {
		CatDogQueue test = new CatDogQueue();

		Pet dog1 = new Dog();
		Pet cat1 = new Cat();
		Pet dog2 = new Dog();
		Pet cat2 = new Cat();
		Pet dog3 = new Dog();
		Pet cat3 = new Cat();

		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);

		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);

		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);
		while (!test.isDogQueueEmpty()) {
			System.out.println(test.pollDog().getPetType());
		}
		while (!test.isEmpty()) {
			System.out.println(test.pollAll().getPetType());
		}
	}

}
