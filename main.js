

function 
    has_duplicate(nums){
            
        for (let i = 0; i < nums.length; i++) {
            if (nums[i] === nums.length){
                return true;
            }
            return false;
        }
    }

    console.log(has_duplicate([1,2,3,3]));