package com.aa.act.interview.org;

import java.util.Optional;

public abstract class Organization {

	private Position root;
	
	public Organization() {
		root = createOrganization();
	}
	
	protected abstract Position createOrganization();
	
	
	// * @param person
	//	public Person(String name, Employee employee) {
	//	this.name = name;
		static void personName(String person) {
			System.out.println("Employees name: " + person);
		}
			
			static void positionTitle(String title) {
			System.out.println("Employees title: " + title);
			}
		
		
	// * @param title
	//	public Title(String title, Employee employee) {
	//	this.title = title;

//	 * @return the newly filled position or empty if no position has that title
	// */
		
	public Optional<Position> hire(Name person, String title) {
		
		personName(person);
		positionTitle(title);
		if (title == null || person == null)
			throw new IllegalArgumentException("Person is not an employee or does not have a title");
		return Optional.empty();
	}

//		Organization person = new Organization(title);
//		Organization title = new Organization(Name, person);
//		person.add(title);
//		System.out.println(person);

	@Override
	public String toString() {
		return printOrganization(root, "");
	}
	
	private String printOrganization(Position pos, String prefix) {
		StringBuffer sb = new StringBuffer(prefix + "+-" + pos.toString() + "\n");
		for(Position p : pos.getDirectReports()) {
			sb.append(printOrganization(p, prefix + "\t"));
		}
		return sb.toString();
	}
}