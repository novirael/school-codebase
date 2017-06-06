#!/usr/bin/env python
# -*- coding: utf-8 -*-
import argparse

import unicodecsv as csv


create = """
CREATE TABLE CrimesFromFile
(
    ID INT,
    CaseNumber CHAR(32),
    Date DATETIME,
    Block CHAR(32),
    IUCR CHAR(32),
    PrimaryType CHAR(32),
    Description CHAR(256),
    LocationDescription CHAR(256),
    Arrest CHAR(32),
    Domestic CHAR(32),
    Beat CHAR(32),
    District CHAR(32),
    Ward CHAR(32),
    CommunityArea CHAR(32),
    FBICode CHAR(32),
    XCoordinate CHAR(32),
    YCoordinate CHAR(32),
    Year CHAR(32),
    UpdatedOn DATETIME,
    Latitude CHAR(32),
    Longitude CHAR(32)
);
"""

insert = """
INSERT INTO CrimesFromFile(
    ID,
    CaseNumber,
    Date,
    Block,
    IUCR,
    PrimaryType,
    Description,
    LocationDescription,
    Arrest,
    Domestic,
    Beat,
    District,
    Ward,
    CommunityArea,
    FBICode,
    XCoordinate,
    YCoordinate,
    Year,
    UpdatedOn,
    Latitude,
    Longitude
)
VALUES
"""


def export_from_csv_to_sql(src_filename, dst_filename):
    with open(dst_filename, "w") as dst_file:
        dst_file.write(create)
        dst_file.write(insert)
        with open(src_filename, "r") as src_file:
            write_values(src_file, dst_file)


def write_values(src_file, dst_file):
    rows = csv.reader(src_file)
    print(next(rows))

    for row_idx, row in enumerate(rows):
        items = []
        for item_idx, item in enumerate(row):
            if item_idx == 0:
                items.append(item)
            elif item_idx < 21:
                items.append('\'' + item + '\'')

        line = "\n,(%s)"
        if row_idx == 0:
            line = " (%s)"

        dst_file.write(line % ",".join(items))

        if row_idx % 100000:
            print("Exported %d rows" % row_idx)

    dst_file.write(";\n")


if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('source_file')
    parser.add_argument('destination_file')
    args = parser.parse_args()
    export_from_csv_to_sql(args.source_file, args.destination_file)
