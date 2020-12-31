//provider "aws" {
//  region  = "eu-central-1"
//  version = "~> 2.0"
//}

provider "aws" {
  alias  = "virginia"
  region = "us-east-1"
}

resource "aws_s3_bucket" "virginia_bucket" {
  provider = aws.virginia
  bucket   = ""
}

resource "aws_s3_bucket" "default" {
  bucket = ""

}
