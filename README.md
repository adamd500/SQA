# SQA
<h1>Demonstrating Software Quality</h1>

<h2>Sprint backlog</h2>

| Sprint 	|                                                                                                         Task                                                                                                        	| Estimate 	| Points 	| Priority 	|      Status 	| Developer 	|
|-------:	|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:	|---------:	|--------	|---------:	|------------:	|-----------	|
|    1   	| Create Code Review Checklist                                                                                                                                                                                        	|  20 mins 	| 1      	|   High   	| Complete 	| Adam      	|
|    1   	| Create Object Classes                                                                                                                                                                                               	|  20 mins 	| 1      	|   High   	| Complete 	| Adam      	|
|    2   	| Create functionality to create rubric with ability to add criterion, get list of all rubrics and get specific rubric. Include unit tests                                                                            	|    2h    	| 6      	|   High   	| Complete 	| Adam      	|
|    2   	| Create functionality for new Student Grade allowing for addition of a score for a particular criterion for a grade. Add functionality to get all student grades associated with specific rubric. Include unit tests 	|    2h    	| 6      	|   High   	| Not Started 	| Adam      	|
|    2   	| Create functionality to calculate summaries across all grades. This should include average, standard deviation, min and max scores for specific criteria. Include unit tests                                       	|    3h    	| 8      	|   High   	| Not Started 	| Adam      	|
|    3   	| Run a test coverage tool to check testing. Make changes to testing to get coverage to an high standard                                                                                                              	|    3h    	| 8      	|   High   	| Not Started 	| Adam      	|

**Sprint 1**
Sprint 1 has a total velocity of 2, this is calculated by adding the story points together. The tasks of sprint 1 are essential to the rest of the tasks and must be completed before spring 2 can commence. While the tasks are important they do not have the complexity of sprint 2 or 3 and can be achieved in a short period of time. Once sprint 1 is complete the building of complex functionality can commence.

Sprint 1 reflection - This sprint went as according to plan. The code review and object classes are complete without any problems allowing for the work to begin on sprint 2. 

**Sprint 2**
Sprint 2 has a velocity of 20. This score has been calculated by the established points of sprint 1 as reference. The complexity and estimated time consumption of sprint 2 is far greater than sprint one and sprint 3 and thus explains why the story points are much higher. In this sprint the core functionality will be built and tested. This sprint involves researching of calculations which further added to its estimate.

Sprint 2 reflection - Sprint took sluightly longer than expected. Writing tests took a little bit of practice and research to get a good understanding of how to test properly. This delay should however make it easier to test for the next sprint as I am more informed on how to create them.

**Sprint 3**
Sprint 3 has a velocity of 8. This estimate has been calculated by comparison to task 3 of sprint 2, which involves research and testing. In this sprint a testing tool must be ran and appropriate tests added to improve the test quality. 


<h2>Code Review Checklist</h2>

Before any code is merged, please follow these checks to ensure code is up to standard and follows the same format. When reviewing a pull request please review the code with these points in mind before approving and merging.

- All code is accompanied with unit tests to ensure efficiency
- All code has documentation for the next reviewer and future developer
- Code is understandable
- Code is fit for purpose